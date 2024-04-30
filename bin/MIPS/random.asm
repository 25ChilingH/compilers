# Prompting the user to guess a random number that the program generates
# between 0 and 1000. It tells the user whether their guess was too low or too high,
# ending when the user guesses the number correctly.
#
# @author Chiling Han
# @version April 25, 2024

.data
	msg: .asciiz "Guess a number between 0 and 1000: \n"
	high: .asciiz "Guess is too high\n"
	low: .asciiz "Guess is too low\n"
	eq: .asciiz "Guess is correct!\n"
.text
.globl main

main:
	li $a1, 1000
	li $v0, 42 # generates random number < 1000
	syscall
	
	move $t0, $a0 # stores random number < 1000 in $t0
	
	loop:
		li $v0, 4
		la $a0, msg
		syscall
		
		li $v0, 5
		syscall
		move $t1, $v0 # user's guess
		
		beq $t1, $t0, end
		
		# prints if guess was greater or less than random number
		blt $t1, $t0, less
		bgt $t1, $t0, more
		
		less:
			li $v0, 4
			la $a0, low
			syscall
			
			j loop
			
		more:
			li $v0, 4
			la $a0, high
			syscall
			
			j loop
	
	end:
		li $v0, 4
		la $a0, eq
		syscall
		
		li $v0, 10
		syscall
