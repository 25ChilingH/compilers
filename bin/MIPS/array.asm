# Prompting the user to input ten numbers to store in a 40 byte array.
# It finds the sum, average, minimum, and maximum of these ten numbers.
#
# @author Chiling Han
# @version April 25, 2024

.data
	array: .space 40 # allocates 40 bytes for a 10 element integer array
	msg: .asciiz "Input 10 numbers: \n"
	sum: .asciiz "Sum: "
	avg: .asciiz "Average: "
	minS: .asciiz "Minimum: "
	maxS: .asciiz "Maxinum: "
	nline: .asciiz "\n"

.text
.globl main

main:
	li $v0, 4
	la $a0, msg
	syscall
	
	la $t7, array # load base address of array into register $t7
	
	li $t0, 0
	li $t1, 10
	move $t2, $t0 # counter variable
		
	# reads 10 inputted integers
	loop:
		bge $t2, $t1, processArray
		
		li $v0, 5
		syscall
		move $t4, $v0 # inputted numbers
		
		sw $t4, ($t7)
		addu $t7, $t7, 4 # add to memory pointer for array
		
		addu $t2, $t2, 1 # increment counter
		
		j loop

	# sets up values for the array loop
	processArray:
		la $t7, array # load base address of array into register $t7
	
		li $t0, 0
		li $t1, 10
		move $t2, $t0 # counter variable
		
		li $t3, 0 # sum
	
		li $t8, 0x7FFFFFFF # min
		li $t9, 0x80000000 # max 
	
	# finds the min, max, sum
	loopArray:
		bge $t2, $t1, end
		
		lw $t4, ($t7)
		addu $t7, $t7, 4 # add to memory pointer for array
		
		addu $t3, $t3, $t4 # add to sum
		
		addu $t2, $t2, 1 # increment counter
		
		blt $t4, $t8, min
		bgt $t4, $t9, max
		
		j loopArray
	
	min:
		move $t8, $t4 # set inputted integer to min
		j loopArray
	
	max:
		move $t9, $t4 # set inputted integer to max
		j loopArray
	
	# print out the calculated sum, average, min, max
	end:
		li $v0, 4
		la $a0, sum
		syscall
		li $v0, 1
		move $a0, $t3 # sum
		syscall
		li $v0, 4
		la $a0, nline
		syscall
		
		li $v0, 4
		la $a0, avg
		syscall
		li $v0, 1
		div $t0, $t3, 10 # average
		move $a0, $t0
		syscall
		li $v0, 4
		la $a0, nline
		syscall
		
		li $v0, 4
		la $a0, minS
		syscall
		li $v0, 1
		move $a0, $t8 # min
		syscall
		li $v0, 4
		la $a0, nline
		syscall
		
		li $v0, 4
		la $a0, maxS
		syscall
		li $v0, 1
		move $a0, $t9 # max
		syscall
		li $v0, 4
		la $a0, nline
		syscall
		
		li $v0, 10
		syscall
