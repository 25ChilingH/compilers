.data

.text
	.globl main
	main:
		li $a0, 6
		jal findFib
		
		move $a0, $v0
		li $v0, 1
		syscall
		
		li $v0, 10
		syscall
	
	.globl findFib
	findFib:
		# push $ra onto the stack
		subu $sp, $sp, 4
		sw $ra, ($sp)
		
		# base case
		move $v0, $a0
		ble $a0, 1, endFib
		
		# push n onto the stack
		subu $sp, $sp, 4
		sw $a0, ($sp)
		
		# fib(n - 1)
		subu $a0, $a0, 1
		jal findFib
		
		# pop n from the stack
		lw $t0, ($sp)
		addu $sp, $sp, 4
		
		# push fib(n - 1) onto the stack
		subu $sp, $sp, 4
		sw $v0, ($sp)
		
		# fib(n - 2)
		subu $a0, $t0, 2
		jal findFib
		
		# pop fib(n - 1) from the stack
		lw $t1, ($sp)
		addu $sp, $sp, 4
		
		addu $v0, $v0, $t1
			
	
	endFib:
		lw $ra, ($sp)
		addu $sp, $sp, 4
		jr $ra
		
