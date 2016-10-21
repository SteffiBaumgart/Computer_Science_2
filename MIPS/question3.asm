# Question 3
# Palindromic Primes between a Range 

.data

	enterStart:     .asciiz 	"Enter the starting point N:\n"
	enterEnd:       .asciiz         "Enter the ending point M:\n"
	message:        .asciiz         "The palindromic primes are:\n"
	newLine:        .asciiz         "\n"
	
	num: 		.word		0
	rev:	        .word		0
	curr: 	        .word		0
	ten:		.word	       10
	one:		.word		1
	remainder:	.word		0
	i:		.word		2
	
	end:             .word          0
	start:           .word          0

.text

main:
	
	# Output
	li $v0, 4			# print string 
	la $a0, enterStart		# which string?	
	syscall				# execute


	# Input	
	li $v0, 5 			# read
	syscall                         # execute 
	sw $v0, num			# save input
	sw $v0, curr
	sw $v0, start
	
	
	# Output
	li $v0, 4			# print string 
	la $a0, enterEnd		# which string?	
	syscall				# execute
	
        # Input	
	li $v0, 5 			# read
	syscall                         # execute 
	sw $v0, end		        # save input
	
	
	# Output
	li $v0, 4			# print string 
	la $a0, message		        # which string?	
	syscall				# execute




	# Variables
	lw $s0, start
	lw $t0, end
	
	lw $s1, num
	lw $s2, rev
	lw $s3, curr
	lw $s4, ten    #have to have register as can't use int in mul and div operations
	lw $s5, one    #have to have reigster as can't use int in branch 
	lw $s6, remainder
	lw $s7, i
	

#range is NOT INCLUSIVE OF THE FIRST VALUE 

loopAll: addi  $s0, $s0, 1  #starting value ++

          #Reinitialize NumA, CurrA to current value; Rev = 0
          la $s1, ($s0)
          la $s3, ($s0)
          mul $s2, $s3, $zero 
           
         bge   $s0 , $t0, exit  #if start <= end -> exit 
         
        
    #PALINDROME 
    loop:
	blt $s3, $s5, decision		# checks if curr<1 -> finished building reverse
	rem $s6, $s3, $s4		# stores remainder
	div $s3, $s3, $s4		# divides curr by 10 DECOMPOSE
	mul $s2, $s2, $s4               # multiplies curr by 10 
	add $s2, $s2, $s6               # add remainder back  RECOMPOSE 
	j loop				# repeats the loop

       decision:
	beq $s2, $s1, true 	        # if reverse == original number 
	j loopAll
					
	
            # Palindrome, but PRIME? 
	    true:	
		        la $s3, ($s0)    # make curr the original value again
	   
			beq $s1,$s7,tr	        # if num=i -> calls true 
			div $s3, $s7 	        # current/i
			mfhi $s6		# stores the remainder of the div above 
	
			beq $s6, $zero, fa	# if rem == 0  -> calls false 
			addi $s3, $s3, 1	# i++
			j true			# continues UNTIL BRANCHES
			
			
			tr:  #Is a PPrime -> Print 
		
				move $a0, $s0
				li $v0, 1 
				syscall
		                la $a0, newLine
		                li $v0, 4
		                syscall 
		                j loopAll  
					
			fa: j loopAll
		
exit:	
	li $v0, 10
	syscall
	

		
