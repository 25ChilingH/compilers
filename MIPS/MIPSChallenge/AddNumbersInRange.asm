# This program prompts the user to enter two numbers in the range
# [1000 - 5000] inclusive. Once the user enters the two values successfully
# it prints the sum of the two numbers
#
# @author Chiling Han, Sophia Zhu, Benjamin Fu
# @version May 2, 2024
	
	
	.data

msg: 	.asciiz		"Enter a number between 1000 and 5000: "

	.text

	.globl main

main:
	prompt1:
		li $v0, 4
		la $a0, msg
		syscall
		
		li $v0, 5
		syscall
		move $t0, $v0
		
		bgt $t0, 5000, prompt1
		blt $t0, 1000, prompt1
	
	prompt2:
		li $v0, 4
		la $a0 msg
		syscall
		
		li $v0 5
		syscall
		move $t1, $v0
		
		bgt $t1, 5000, prompt2
		blt $t1, 1000, prompt2
		
	addu $t2, $t0, $t1
	li $v0 1
	move $a0, $t2
	syscall
	
	
	li $v0, 10
	syscall
	

	

