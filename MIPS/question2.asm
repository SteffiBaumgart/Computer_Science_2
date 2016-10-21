# Question 2 
#Primes

.data
	enter:   .asciiz    "Enter a number:\n"
	prime:   .asciiz         "It is prime"
	notPrime:.asciiz     "It is not prime"
	num:       .word		 0
	remainder: .word		 0   #rem is a reserved word!
	i:         .word		 2
	curr:      .word		 0


.text

main:

	# Output
	li $v0, 4			# print string 
	la $a0, enter			# which string?	
	syscall				# execute

	# Input	
	li $v0, 5 			# read
	syscall                         # execute 
	sw $v0, num			# save input
	sw $v0, curr

        # Load variables
	lw $s1, num
	lw $s2, remainder
	lw $s3, i
	lw $s4, curr


loop:
	beq $s1,$s3 ,true	# if num==i -> calls true 
	div $s4, $s3 	        # current/i
	mfhi $s2		# stores the remainder of the div above 
	
	beq $s2, $zero, false	# if rem == 0  -> calls false 
	addi $s3, $s3, 1	# i++
	j loop			# continues UNTIL BRANCHES

true:
	li $v0, 4 			# print string
	la $a0, prime			# which string?	
	syscall				# execute 	
	j exit

false:
	li $v0, 4 			# print string
	la $a0, notPrime		# which string?	
	syscall				# execute	
	j exit


exit:
	li $v0, 10			# exits
	syscall
	
