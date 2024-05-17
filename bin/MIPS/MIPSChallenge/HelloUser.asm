# Prompts the user for their name then print's Hello user name
# 
# @author Chiling Han, Sophia Zhu, Benjamin Fu
# @version May 2, 2024

	.data
	
msg:	.asciiz		"Enter your name: "	# prompt for the user to enter name
hello:	.asciiz 	"Hello "		# used to display Hello user name
name:	.space		20			# space to save the name in memory
len:	.word		20			# max characters allowed in name


	.text

	.globl main

main:

	# Your code goes here
	li $v0, 4
	la $a0, msg
	syscall
	
	lw $a1, len
	la $a0, name
	li $v0, 8
	syscall

	li $v0, 4
	la $a0, hello
	syscall
	
	li $v0 4
	la $a0, name
	syscall

	# Normal termination
	li $v0, 10
	syscall
