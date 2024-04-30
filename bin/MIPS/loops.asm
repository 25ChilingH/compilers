# Prompting the user to input three numbers of a for loop's lower bound,
# upper bound, and step. It prints the loop counter.
#
# @author Chiling Han
# @version April 25, 2024

.data
	msg: .asciiz "Enter the low, high, and step to print integers in a loop:\n"
	nline: .asciiz "\n"
	
.text 0x00400000
.globl main

main:
	li $v0, 4
	la $a0, msg
	syscall

	li $v0, 5
	syscall
	move $t0, $v0 # inputted low integer
	
	li $v0, 5
	syscall
	move $t1, $v0 # inputted hi integer
	
	li $v0, 5
	syscall
	move $t2, $v0 # inputted step integer

	move $t3, $t0 # counter variable
	
	
	loop:
		bge $t3, $t1, end # ends if counter is greater than upper bound
		
		li $v0, 1
		move $a0, $t3 # prints out the counter
		syscall
		
		li $v0, 4
		la $a0, nline
		syscall
		
		addu $t3, $t3, $t2 # increments counter by step
		j loop
	
	end:
		li $v0, 10
		syscall
	
	
	
