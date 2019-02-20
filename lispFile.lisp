;;Greg Martin
;;Lisp List summation
;;Lisp Maximum Contiguous Array

;;This is part One of the assignment but is used in the rest of the parts
(defvar *total* 0)

(defun sum (&rest nums)
  (dolist (num nums)
    (setf *total* (+ *total* num))
    )
  )

;;this is kadane's algorithm, which provides the largest contiguous subarray
(defun kadane (&rest nums)
  (format t "List ~s ~%" nums)
  (loop
     with max-total = 0
     with max-here = 0
     for i in nums
     do
       (cond ((numberp i)
         (setf max-total (max 0 (+ max-total i)))
         (setf max-here (max max-here max-total)))
	     ;;Checks if list item is a list or atom
	     ((listp i)
	      (sum (first i) (second i))
	      (setf max-total (max 0 (+ max-total *total*)))
	      (setf max-here (max max-here max-total))
	      (format t "Sublist that was added together: ~s ~%" i)
              (setf *total* 0)) 
	     (t
	       (error "error")))
     finally (return max-here))
  )

(format t "Maximum of above list: ~d ~%" (kadane -2 4 -3 5 -3 1 -2 3))
(format t "Maximum of above list: ~d ~%" (kadane -2 -3 4 -1 -2 1 5 -3))
(format t "Maximum of above list: ~d ~%" (kadane -2 -4 '(5 6) 3 '(5 -6) 6 1))
