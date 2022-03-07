-- Tables
SELECT * FROM salary;
SELECT * FROM performance;
SELECT * FROM student;
-- Join Tables
SELECT name, lastname, married, num_kids, current_gpa, credits_num_per_year, student_salary_year, parents_salary_year FROM student as st 
JOIN performance as pf ON st.performance_id_performance = pf.id_performance
JOIN salary as sal ON st.salary_id_salary = sal.id_salary;
-- WHERE    Students not likely to get a scholarship
SELECT name, lastname, married, num_kids, current_gpa, credits_num_per_year, student_salary_year, parents_salary_year FROM student as st 
JOIN performance as pf ON st.performance_id_performance = pf.id_performance
JOIN salary as sal ON st.salary_id_salary = sal.id_salary
WHERE parents_salary_year > 120000 and married="N";
-- Update
--
UPDATE student
SET num_kids = 0
WHERE name='Logan' and lastname="Hull";
SELECT name, lastname, married, num_kids, current_gpa, credits_num_per_year, student_salary_year, parents_salary_year FROM student as st 
JOIN performance as pf ON st.performance_id_performance = pf.id_performance
JOIN salary as sal ON st.salary_id_salary = sal.id_salary
WHERE parents_salary_year > 120000 and married="N";
-- SUM
SELECT married, SUM(num_kids) as Total_Num_Kids FROM student
GROUP BY married;
-- AVERAGE
select AVG(parents_salary_year) as average from salary;
-- Below Average
SELECT name, lastname, married, num_kids, current_gpa, credits_num_per_year, student_salary_year, parents_salary_year FROM student as st 
JOIN performance as pf ON st.performance_id_performance = pf.id_performance
JOIN salary as sal ON st.salary_id_salary = sal.id_salary
where parents_salary_year <(select AVG(parents_salary_year) as average from salary)
ORDER BY parents_salary_year DESC;

SELECT name, lastname, married, num_kids, current_gpa, credits_num_per_year, student_salary_year, parents_salary_year FROM student as st 
JOIN performance as pf ON st.performance_id_performance = pf.id_performance
JOIN salary as sal ON st.salary_id_salary = sal.id_salary
WHERE parents_salary_year < 102478.5714
ORDER BY parents_salary_year DESC;

-- FULL CRITERIA
SELECT name, lastname, married, num_kids, current_gpa, credits_num_per_year, student_salary_year, parents_salary_year FROM student as st 
JOIN performance as pf ON st.performance_id_performance = pf.id_performance
JOIN salary as sal ON st.salary_id_salary = sal.id_salary
WHERE parents_salary_year < 102478.5714 and married="Y" and current_gpa > 3 and credits_num_per_year > 30
ORDER BY parents_salary_year DESC;
-- Second Criteria
SELECT name, lastname, married, num_kids, current_gpa, credits_num_per_year, student_salary_year, parents_salary_year FROM student as st 
JOIN performance as pf ON st.performance_id_performance = pf.id_performance
JOIN salary as sal ON st.salary_id_salary = sal.id_salary
WHERE current_gpa > 3.5 and credits_num_per_year > 40
ORDER BY credits_num_per_year DESC;
-- WIll not get Scholarhsip
SELECT name, lastname, married, num_kids, current_gpa, credits_num_per_year, student_salary_year, parents_salary_year FROM student as st 
JOIN performance as pf ON st.performance_id_performance = pf.id_performance
JOIN salary as sal ON st.salary_id_salary = sal.id_salary
where parents_salary_year > (select AVG(parents_salary_year) as average from salary)
and student_salary_year>(select AVG(student_salary_year) as average from salary)
or current_gpa < 3
ORDER BY parents_salary_year DESC;