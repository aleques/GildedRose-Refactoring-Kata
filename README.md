# GildedRose-Refactoring-Kata

### Instructions:
Run: There is no manifest specifying main class, 
So, you need to know how to download / clone the project and run by yourself using javac with your favorite IDE

### Comment before start
Hi,

Yesterday I struggled a while trying to make work the tool TextTest, so I gave up and I did one comparison by myself.
And now I need to sleep
To see this texttest, run the tests in the class TexttestFixtureAfterRefac
Normally I prefere spend more time use a good / well-mainteined / already-done solution instead of homemades.

- It took so much more than 4 hours, I couldn't code a single shot, so I did some part yesterday night, some part tonight.
- This long time that I took to finish are related to 
    1. I'm not used to do tests or TDD
    2. IMHO, I should have take a carefully simple look in the implementation before start the coding tests
    3. I'm tired :P
    4. Due to 2, I did some over-engineering
    
### Refactoring that I didn't due to the time that I have now
- I would create one class per item type, an interface with update signature and maybe this interface should call ItemAdapter or ItemWrapper.
- Refactoring my TestData putting the edge cases related to quality max 50
    
### Some thoughts:
- Now I realize that my tests are not enough and they need to be refactored, specially for edge cases related to the general quality limit of 50
- I tried to do a mix between clean code and verborragic code. As a consequence of this, my tests are a bit complex with some logic
- First I started with a "Triangulation Technique" in the first method (it's not visible on commits), doing tests for one day, after for 2 days, then I changed to use one Array.
- I choose to not put any other dependency such as Hamcrest and also I choose to use always assertEquals with some description.
- Some math resolutions that I did - min, max - I should take it of in a real world and probably use Matches or Spring MVC test mock xxx, something like this. I like Math resolutions, but some other people dont.


Thank you!

Best,

Alex Oliveira



