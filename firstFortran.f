program hello
IMPLICIT NONE
INTEGER :: input, quarters, dimes, nickles, pennies
CHARACTER(LEN = 8) :: DateINFO
CHARACTER(LEN = 4) :: Year, Month*2, Day*2
CHARACTER(LEN = 10) :: TimeINFO, PrettyTime*12
CHARACTER(LEN = 2) :: Hour, Minute, Second*6

CALL DATE_AND_TIME(DateINFO,TimeINFO)

Year = DateINFO(1:4)
Month = DateINFO(5:6)
Day = DateINFO(7:8)
Hour = TimeINFO(1:2)
Minute = TimeINFO(3:4)
WRITE(*,*) 'Date information'
WRITE(*,*) 'mo-dy-year,Hr:mi'
WRITE(*,*) Month,"-",Day,"-",Year,",",Hour,":",Minute

WRITE(*,'(a)',advance='no') 'Welcome, please enter the amount of change from 1-99 (Enter something besides that to exit):'
READ *, input
DO WHILE (input > 0 .and. input < 100)
        call CHANGE(input,quarters,dimes,nickles,pennies)
        IF (quarters == 0 .and. dimes == 0 .and. nickles == 0) THEN
                WRITE(*,'(I1, A)') pennies,' Pennies '
        ELSE IF (quarters == 0 .and. dimes == 0 .and. pennies == 0) THEN
                WRITE(*,'(I1,A)') nickles,' Nickels '
        ELSE IF (quarters == 0 .and. nickles == 0 .and. pennies == 0) THEN
                WRITE(*,'(I1,A)') dimes,' Dimes '
        ELSE IF (dimes == 0 .and. nickles == 0 .and. pennies == 0) THEN
                WRITE(*,'(I1,A)') quarters,' Quarters '
        ELSE IF (quarters == 0 .and. dimes == 0) THEN
                WRITE(*,'(I1,A)',advance='no') nickles,' Nickels '
                WRITE(*,'(I1,A)') pennies,' Pennies '
        ELSE IF (quarters == 0 .and. nickles == 0) THEN
                WRITE(*,'(I1,A)',advance='no') dimes,' Dimes '
                WRITE(*,'(I1,A)') pennies,' Pennies '
        ELSE IF (quarters == 0 .and. pennies == 0) THEN
                WRITE(*,'(I1,A)',advance='no') dimes,' Dimes '
                WRITE(*,'(I1,A)') nickles,' Nickels '
        ELSE IF (dimes == 0 .and. nickles == 0) THEN
                WRITE(*,'(I1,A)',advance='no') quarters,' Quarters '
                WRITE(*,'(I1,A)') pennies,' Pennies '
        ELSE IF (dimes == 0 .and. pennies == 0) THEN
                WRITE(*,'(I1,A)',advance='no') quarters,' Quarters '
                WRITE(*,'(I1,A)') nickles,' Nickels '
        ELSE IF (nickles == 0 .and. pennies == 0) THEN
                WRITE(*,'(I1,A)',advance='no') quarters,' Quarters '
                WRITE(*,'(I1,A)') dimes,' Dimes '
        ELSE IF (quarters == 0) THEN
                WRITE(*,'(I1,A)',advance='no') dimes,' Dimes '
                WRITE(*,'(I1,A)',advance='no') nickles,' Nickels '
                WRITE(*,'(I1,A)') pennies,' Pennies '
        ELSE IF (dimes == 0) THEN
                WRITE(*,'(I1,A)',advance='no') quarters,' Quarters '
                WRITE(*,'(I1,A)',advance='no') nickles,' Nickels '
                WRITE(*,'(I1,A)') pennies,' Pennies '
        ELSE IF (nickles == 0) THEN
                WRITE(*,'(I1,A)',advance='no') quarters,' Quarters '
                WRITE(*,'(I1,A)',advance='no') dimes,' Dimes '
                WRITE(*,'(I1,A)') pennies,' Pennies '
        ELSE IF (pennies == 0) THEN
                WRITE(*,'(I1,A)',advance='no') quarters,' Quarters '
                WRITE(*,'(I1,A)',advance='no') dimes,' Dimes '
                WRITE(*,'(I1,A)') nickles,' Nickels '
        ELSE
                WRITE(*,'(I1,A)',advance='no') quarters,' Quarters '
                WRITE(*,'(I1,A)',advance='no') dimes,' Dimes '
                WRITE(*,'(I1,A)',advance='no') nickles,' Nickels '
                WRITE(*,'(I1,A)') pennies,' Pennies '
        END IF
        WRITE(*,'(a)',advance='no') "Enter another number from 1-99 or something else to exit:"
        READ *, input
        ENDDO
end program hello

subroutine CHANGE(startAmount,numOfQuarters,numOfDimes,numOfNickels,numPennies)
        IMPLICIT NONE
        INTEGER, INTENT( IN ) :: startAmount
        INTEGER, INTENT( OUT ) :: numOfQuarters, numOfDimes
        INTEGER, INTENT( OUT ) :: numOfNickels, numPennies
        INTEGER :: newAmount
        numOfQuarters = (startAmount / 25)  
        newAmount = startAmount - (numOfQuarters*25)
        numOfDimes = (newAmount/10)
        newAmount = newAmount - (numOfDimes*10)
        numOfNickels = (newAmount/5)
        newAmount = newAmount - (numOfNickels*5)
        numPennies = (newAmount/1)
end subroutine CHANGE
