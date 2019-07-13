# GildedRose-Refactoring-Kata

#### Necessary tools 
- git
- maven with settings configured to download artifacts from some repository ( maven central repository, for example )
- java development kit 8 or higher
- A program for command line interface ( cmd for example )


#### Instructions via command line:
- clone or download project to your machine
- access the folder of the project using command line interface
- run the command mvn test

<hr />

#### Comments

Hi,

I struggled a while trying to make work the tool TextTest, so I gave up and I did one comparison by myself.


To see this texttest, run the tests in the class TexttestFixtureAfterRefac (It's marked as Ignore).


Generally I prefer spend more time trying to use a good / well-mainteined / already-done solution instead of homemade solutions.


It took me so much more than 4 hours. This long time that I took to finish are related to:

1. I'm not used to do tests or TDD
2. I should have take a carefully look in the implementation before start coding tests
4. Due to 2, I did some over-engineering


The thing is there was my learning curve and I underestimate the basic idea of unit tests. Even reading the tips such as


"If you focus solely on describing the requirements in an executable way, you tend to miss edge cases and there are gaps in the regression protection. If you focus only on regression protection, you’ll spend time analysing the edge cases, and measuring code coverage to see how well you’re doing, but the test cases can become quite hard to read and understand."

<hr />
    
#### Some thoughts:
- I tried to do a mix between clean code and verborragic code. As a consequence of this, my tests are a bit complex
- First I started with a "Triangulation Technique" in the first method (it's not visible on commits), doing tests for one day, after for 2 days, then I changed to use one Array. Then, I realized that it was a mess
- I choose to not put any other dependency such as Hamcrest and also I choose to use more assertEquals.



