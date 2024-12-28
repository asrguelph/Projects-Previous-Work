#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "a3q1_header.h"

Variable variables[10];
int varCount;

// The createNode function allocates memory to the tree and creates a new node using the given data before returning the node.
Node* createNode(char *data){
    Node * nodePtr = malloc(sizeof(Node));
    strcpy(nodePtr->data,data);
    nodePtr->left = NULL;
    nodePtr->right = NULL;
    
    return nodePtr;
}

// The parseExpression function parses the expression string passed in from command line, stores the information in a new node, and returns the root node of the tree.
Node* parseExpression(char *expr){
    Node * root;
    char * rootLeft = NULL;
    char operator[2];//used for storing operator character
    char value;//used for storing value character
    int parenCounter = 0;//for checking paranthesis
    int splitIndex = -1;//to hold the index to split from (from highest level operator)
    
    if (expr[0] == '(' && expr[strlen(expr) - 1] == ')') {//remove outer brackets
        expr[strlen(expr) - 1] = '\0';//get rid of outer )
        expr++;//move to next character (get rid of outer ( )
    }

    for (int i = 0; expr[i] != '\0'; i++) {//goes through expression until it finds main operator 
        if (expr[i] == '(') {
            parenCounter++;
        }
        else if (expr[i] == ')') {
            parenCounter--;
        }
        else if ((expr[i] == '+' || expr[i] == '-' || expr[i] == '*' || expr[i] == '/') && parenCounter == 0) {//recursively create subtrees, starting with the root
            value = expr[i];//storing the highest level operator
            splitIndex = i;
            break;
        }
    }

    if (splitIndex != -1) {//if a operator is found split the expression
        operator[0] = value;
        operator[1] = '\0';
        rootLeft = malloc(sizeof(char)*100);
        strcpy(rootLeft,expr);
        rootLeft[splitIndex] = '\0';//setting up left root
        root = createNode(operator);
        root->left = parseExpression(rootLeft); //creating a left subtree only taking until the middle root part
        root->right = parseExpression(expr+splitIndex+1); //creating a right subtree only taking after the middle root part
        free(rootLeft);
        return root;
    }
    return createNode(expr);//when value is a single operand (split to the point where x1,5.12, etc. just remains)
}
// The preOrder function prints tree nodes in preorder traversal.
void preorder(Node *root){
    if (root == NULL) {
        return;
    }
    else {
        printf("%s ", root->data);
        preorder(root->left);
        preorder(root->right);
    }
    
}

// The inOrder function prints tree nodes in inorder traversal fully parenthesized.
void inorder(Node *root){
    if (root == NULL) {//base case for when root is null
        return;
    }
    else {
        printf("(");//print outer bracket
        inorder(root->left);//recursively go to left node
        printf("%s", root->data);
        inorder(root->right);//recursively go to right node
        printf(")");//print closing bracket         
    }

}

// The postOrder function prints tree nodes in postorder traversal.
void postorder(Node *root){

    if (root == NULL) {
        return;
    }
    else {
        postorder(root->left);
        postorder(root->right);
        printf("%s ", root->data);
    }

}

// The promptVariables function prompts the user to assign values to each variable found in the expression tree. The values should be stored in the Variables struct.
void promptVariables(Node *root){
    float input;
    bool xExists = false;
    if (root == NULL) {
        return;
    }
    else {
        promptVariables(root->left);
        if (root->data[0] == 'x') {
            for (int i = 0; i < varCount; i++) {//checking if the variable exists
                if (strcmp(variables[i].varName,root->data) == 0 ) {
                    xExists = true;
                }
            }
            if (xExists == false){ //if the does not already exists add it 
                strcpy(variables[varCount].varName,root->data);
                printf("Please enter value for %s: ", root->data);
                scanf("%f", &input);
                variables[varCount].value = input;
                varCount++;
            }
             
        }
        promptVariables(root->right);
    }

}

// The calculate function calculates the expression and returns its result. Division by 0 and/or other error scenarios should be checked.
float calculate(Node *root){
    float val = 0;
    if (root->left == NULL || root->right == NULL ) {//is a value
        if (root->data[0]=='x') {//return variable value in variable array
            for (int i = 0; i < varCount; i++) {
                if (strcmp(root->data,variables[i].varName) == 0) {
                    return variables[i].value;
                }
            }
        }
        else {
            return atof(root->data);
        }
    }
    else {
        switch (root->data[0]) {
            case '/':
                if (calculate(root->right) == 0) {
                    printf("Divide by zero detected, cancelling calculation\n");
                    return 0;
                    break;
                }
                val = calculate(root->left)/calculate(root->right);
                return val;
                break;
            case '+':
                val = calculate(root->left)+calculate(root->right);
                return val;
                break;
            case '-':
                val = calculate(root->left)-calculate(root->right);
                return val;
                break;
            case '*':
                val = calculate(root->left)*calculate(root->right);
                return val;
                break;  
            default:
                printf("Unknown operator, cancelling calculation\n");
                return 0;
                break;

        }
    }
    return val;
}


void freeTree(Node * root) {
    if (root == NULL) {
        return;
    }
    else {//recursively go through binary tree
        freeTree(root->left);
        freeTree(root->right);
        free(root);//free node
    }
    
    
}