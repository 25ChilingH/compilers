.data
	prompt: .asciiz "Enter a number to find the factorial: "
	result: .asciiz "The factorial is: "
	number: .word 0
	res: .word 0

.text
	.globl main
	main:
		# read number from user
		li $v0, 4
		la $a0, prompt
		syscall
		
		li $v0, 5
		syscall
		sw $v0, number
		
		# call factorial function
		lw $a0, number
		jal findFactorial
		sw $v0, res
		
		# display the results
		li $v0, 4
		la $a0, result
		syscall
		
		li $v0, 1
		lw $a0, res
		syscall
		
		# terminate
		li $v0, 10
		syscall
	
	.globl findFactorial
	findFactorial:
		subu $sp, $sp, 8
		sw $ra, ($sp)
		sw $s0, 4($sp)
		
		# base case
		li $v0, 1
		beq $a0, 0, factorialDone
		
		# findFactorial(num - 1)
		move $s0, $a0 
		subu $a0, $a0, 1
		jal findFactorial
		
		mul $v0, $s0, $v0
		
	factorialDone:
		lw $ra, ($sp)
		lw $s0, 4($sp)
		addu $sp, $sp, 8
		
		jr $ra