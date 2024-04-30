# Prompting the user to input a number to determine if the number
# is even or odd.
#
# @author Chiling Han
# @version April 25, 2024

.data
	msg: .asciiz "Enter an integer to find its parity:\n"
	evenMsg: .asciiz "Even\n"
	oddMsg: .asciiz "Odd\n"
	
.text 0x00400000
.globl main

main:
	li $v0, 4
	la $a0, msg
	syscall

	li $v0, 5
	syscall
	move $t0, $v0 # inputted integer
	
	div $t1, $t0, 2
	mul $t2, $t1, 2
	
	# prints appropriate message if input is even or odd
	beq $t0, $t2, even
	bne $t0, $t2, odd
	
	even:
		li $v0, 4
		la $a0, evenMsg
		syscall
		j end
	
	odd:
		li $v0, 4
		la $a0, oddMsg
		syscall
		
	
	end:
		li $v0, 10
		syscall
	
	
	
