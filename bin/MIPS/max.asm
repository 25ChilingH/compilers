.data

.text
	.globl main
	main:
		li $a0, 2
		li $a1, 3
		li $a2, 4
		jal max3
		
		move $a0, $v0
		li $v0, 1
		syscall
		
		li $v0, 10
		syscall
		
	.globl max3
	max3:
		subu $sp, $sp, 4
		sw $ra, ($sp)
		
		jal max2
		
		move $a0, $v0
		move $a1, $a2
		
		jal max2
		
		lw $ra, ($sp)
		addu $sp, $sp, 4
		
		jr $ra
	
	.globl max2
	max2:	

		bgt $a0, $a1, xGreater
		move $v0, $a1
		jr $ra
		
	xGreater:
		move $v0, $a0
		jr $ra
	
