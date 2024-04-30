# Prompting the user to input two numbers to determine their product.
#
# @author Chiling Han
# @version April 25, 2024

.data
	msg: .asciiz "Enter two integers to find their product:\n"
	
.text 0x00400000
.globl main

main:
	li $v0, 4
	la $a0, msg
	syscall

	li $v0, 5
	syscall
	move $t0, $v0 # first integer
	
	li $v0, 5
	syscall
	move $t1, $v0 # second integer
	
	mult $t0, $t1
	mflo $t2      # store the product in $t2
	
	li $v0, 1
	move $a0, $t2
	syscall
	
	li $v0, 10
	syscall
	
	
	
