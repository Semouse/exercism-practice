In this exercise, you'll be implementing rules for calculating the total salary of a employee in a
month. The International Siderurgy Company (ISC) requires assistance in calculating employee
salaries, considering various factors that can impact the final wage.

You have three tasks, and you should use the ternary operator instead of if/else statements to
implement them.

1. **Determine the salary number**\
   Implement the salaryMultiplier method, which returns the salary multiplier based on the number of
   days an employee skipped work. Apply a 15% penalty if the employee skipped at least five days.

2. **Calculate the bonus for products sold**\
   Implement the bonusMultiplier and bonusForProductsSold methods. The ISC pays ten monetary units
   for each product sold, and if an employee sells twenty products or more, the multiplier improves
   to thirteen. bonusMultiplier should determine which multiplier to apply, and bonusForProductSold
   should return the total bonus in monetary units.

3. **Calculate the final salary for employee**\
   Implement the finalSalary method. It should multiply the base salary of 1000.00 by the salary
   multiplier, add the bonus, and return the result. However, salaries should be capped at 2000.00.