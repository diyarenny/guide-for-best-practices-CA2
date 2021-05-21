
# Scrum sprint backlog and task estimation

---

The following is a well-detailed sprint backlog for student grade calculator:

&nbsp;
## Sprint Backlog for Student Grade Calculator

---  

| Priority | Backlog | Owner | Estimate (Hours) | Status |
| ------ | ----------- |------ | ------- |------- |
| 1   | Understanding Requirements | Diya Renny | 0.5 | Completed |
| 2 | Writing Object Classes |Diya Renny | 3 | Completed |
| 3    | Writing Main Class|Diya Renny | 5 | Completed |
| 4    | Planning and Writing Unit Tests|Diya Renny | 4 | Completed |
| 5   | Test Driven Development | Diya Renny | 1 | Completed |
| 6    | Test Coverage Metric| Diya Renny | 2 | Completed |
| 7    | Analysing Results | Diya Renny | 1 | Completed |
| 8   | Team Version Control | Diya Renny | 1 | Completed |
| 9   | Code Review Check List | Diya Renny | 1 | Completed |

&nbsp;
### How to choose estimates :
Planning poker helps a team gain a consensus of correct story point approximation for each item. Here’s how it works:
* In a sprint planning meeting, each developer and tester receives a set of cards.

* A backlog item is brought to the table so that the team may ask questions and clarify features.

* When the discussion is closed, each developer and tester privately selects the card that most accurately reflects their estimate.

* When all cards have been selected, the estimators reveal their cards at the same time. If a consensus is met, it’s time to move on to the next backlog item. If the estimates vary, the leaders discuss until they arrived at a consensus.

It’s useful to have a completed matrix on hand for the estimators to reference during planning poker, as it allows for greater consistency across tasks. Also, it’s useful to set a maximum limit (13, for instance). If a task is estimated to be greater than that limit, it should be split into smaller items. Similarly, if a task is smaller than 1, it should be incorporated into another task.

At this point, within your sprint planning meeting, items in the product backlog can be prioritised and divided out amongst the team based on the team’s workload capacity.

&nbsp; 
### Comparing the difficulty of two tasks with different estimates :

To chose the estimates for the tasks in this project, I determined, the requirements needed to fulfil each task and sizing of all the user stories was initiated by comparing them against the baseline.

While comparing two tasks with different story points, I assigned a point value to each story. Relative values are more important than the raw values. A story that is assigned 2 story points (Test Coverage) is twice as much as a story that is assigned 1 story point (Analysing Results).

&nbsp; 
### How Velocity of a Sprint is calculated :
Velocity is a measures the amount of work finished by the team in each sprint. It helps the team to identify how much progress they can aim to make in a given sprint. Velocity is calculated by adding all the story points given to each user story that is completed by the end of the sprint. It measures output, but not the outcome.

_Example: Last 3 Sprints_

Sprint 1: 3 user stories x 8 story points = 24

Sprint 2: 4 user stories x 8 story points = 32

Sprint 3: 5 user stories x 8 story points = 40
Total = 96

*Average sprint velocity is 96 ÷ 3 = 32.*

&nbsp; 
### How the velocity metric feeds into the next sprint planning?
During sprint planning, the velocity of a team is served as an input to the next sprint. The previous weeks velocity data is used to enhance its use in scrum to deliver customer value. The change in velocity over previous sprints can help a team measure the change in particular processes that can affect the delivery of measurable customer value.

1. Estimate how much amount can be delivered by a particular date
2. Estimate a date for a committed amount of work to be delivered
3. Understand our goals while fixing the amount of work we will commit for a sprint

&nbsp;
## Unit testing and Test-Driven development
Test-driven development (TDD) is a software development process that relies on software requirements being converted to test cases before software is fully developed, and tracking all software development by repeatedly testing the software against all test cases.

I have carefully followed a test-driven development approach where the approach is broken into unit test cases which are developed to specify and validate what the code will do. This [commit](https://github.com/diyarenny/guide-for-best-practices-CA2/commit/0a96cc81d4b5aa4cdc9bf0873fafe5af872954ad) that shows test-driven development in my code and each method calulates a specific value, such as the average and standard deviation of a set of scores, was tested repeatedly with several sets of inputs. 

For example, method and unit test created for calculating the average a Rubric commit. I made sure that the test covers all aspect of the method to calculate the average and this ensures code coverage is improved and the complexity is reduced.

&nbsp;
## Test Coverage Metric
Test coverage is a metric in Software Testing that measures the amount of testing performed by a set of test. 


The test suite I have used to run my unit tests in this project is JUnit 5 and the code coverage tool I have used is EclEmma. EclEmma is a free Java code coverage tool for Eclipse that brings code coverage analysis directly into the Eclipse workbench. Code coverage is a measurement of how many lines/blocks/arcs of your code are executed while the automated tests are running and so helps you to identify the untested parts of your code. To find out the code coverage of a java class I simply right clicked on the class and select "Run As" and then "JUnit Test", making sure EclEmma is installed from Eclipse Marketplace.

It is evident that after writing unit tests for object and caalculations, the gap closes. The gap was visibile before unit tests.

&nbsp;
### *Before writing Unit Tests - Object Test Coverage*
![](https://github.com/diyarenny/guide-for-best-practices-CA2/blob/master/Images/beforeObject.PNG) 

&nbsp;
### *After writing Unit Tests - Object Test Coverage* 
![](https://github.com/diyarenny/guide-for-best-practices-CA2/blob/master/Images/afterObject.PNG)

&nbsp;
### *Before writing Unit Tests - Calculations Test Coverage* 
![](https://github.com/diyarenny/guide-for-best-practices-CA2/blob/master/Images/beforeCalculations.PNG)

&nbsp;
### *After writing Unit Tests - Calculations Test Coverage* 
![](https://github.com/diyarenny/guide-for-best-practices-CA2/blob/master/Images/afterCalculations.PNG)









