# Question 1
# Palidromes 

.data
	enter: 		.asciiz 	"Enter a number:\n"
	palindrome: 	.asciiz 	"It is a palindrome"
	notPalindrome: 	.asciiz 	"It is not a palindrome"
	num: 		.word		0
	rev:	        .word		0
	curr: 	        .word		0
	ten:		.word	       10
	one:		.word		1
	remainder:	.word		0

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

	# Variables 
	lw $s1, num
	lw $s2, rev
	lw $s3, curr
	lw $s4, ten  #have to have register as can't use int in mul and div operations
	lw $s5, one  #have to have reigster as can't use int in branch 
	lw $s6, remainder

#chops digit by digit 
loop:
	blt $s3, $s5, decision		# checks if curr<1 -> finished building reverse
	rem $s6, $s3, $s4		# stores remainder
	div $s3, $s3, $s4		# divides curr by 10 DECOMPOSE
	mul $s2, $s2, $s4               # multiplies curr by 10 
	add $s2, $s2, $s6               # add remainder back  RECOMPOSE 
	j loop				# repeats the loop

decision:
	bne $s2, $s1, false 	        # if reverse != original number 
	li $v0, 4 			# ELSE
	la $a0, palindrome		# it's a palindrome!
	syscall				# execute 
	j exit
	
	
# Not a palindrome
false:
	li $v0, 4 			# print string 
	la $a0, notPalindrome		# which string?	
	syscall				# execute 
	j exit
	
exit:	
	li $v0, 10
	syscall
