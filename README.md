# Testing Workshop
 
## Why:-
 
- To learn how to write unit tests.
- To learn how to write test before functionality (TDD)
- To build & improve testable code incrementally.
- To win a trip to ………🏖.
 
## Preparation 
             
- **Choose your partner & form a team. If & only if you are not able to find anyone, you can work alone. Team may NOT have more than 2 devs working on same laptop.** 👬👭👫
- Update your team name & roster at this link by **Friday (22nd Feb)** evening. https://docs.google.com/spreadsheets/d/1ch0vrzusxIVA9XwuYnE4mZiAjz7l8TscYO17LtAySto/edit?usp=sharing 
- Choose programming language. (Java, python, Javascript, Swift, whichever)
- Choose a unit testing framework (available for the language you chose)
- A branch will be created in Git repository with your team name after finalising. During exercise you should push commits on this branch ONLY.
  - Git Repo location https://github.com/ygaurav/TDDWorkshop.git ) 
  - Learn basic Git (clone repository, checkout branch, commit & push) if you dont know. Github provides a desktop application for easy use.
  - Create Github account if you don’t have it.
- Setup a project & unit test suite. (Successfully run the test suite. No additional mocking/etc framework should be installed. Simple test runners are required.)
- Create a class **TaskManager**
- Create a method **AddTask** with following signature
  - One Parameter - **String**
  - Returns - **Boolean/Bool**
- Write **One** test for **TaskManager**
  - If string parameter passed is empty or null, **AddTask** method should return **false**
- Run test & ensure it passes.
- **All of the above** should be in the **first commit** of **your branch**. 
- **PSA**:- No help will be provided for above setup. You have the next few days to figure out 🙂. Make sure you have a project setup with tests running correctly.
 
## Rules:- 

- I am your **product owner**, not developer, not your lead, mentor, boss, friend. 👨‍💼
- I will be periodically giving new features to add during the exercise.
- Initially you will be writing feature first, then tests. In 2nd half you have to start writing test first (TDD)
- You may ask me anything about current or previous requirement. I may or may not give a clear answer.
- You can & should OBVIOUSLY use internet to get help on stuff. 😅
  - Do not try to be too clever writing code 🤨
  - Do not write more code than feature requires.
  - Do not try to fit some “design pattern” you may be thinking about.
  - Write simple small pieces of code.
- I am a finicky client. I may change my mind about anything anytime, about rules or requirements. 🤪
- Each team will update number of tests you have written as soon as you have written one. 💯
- **Commit guideline** during workshop.
  - Make frequent logical commits. They should nicely explain to reader how your code evolved overtime.
  - Single commit **should not** contain code for separate features (Except if refactoring modifies previously written feature)
  - Multiple commits may be made for one feature. (Mention <**FeatureNumber**>.<**CommitNumber**> at starting of each commit message)
  - Make a judgement call on this. I won’t answer if its a reasonable commit to make. 
  - **Make sure you do NOT mess up others branch. Only work on your branch.**
- At the end of exercise, teams should ensure that they have committed & pushed all their changes. 
 
## Code of Conduct:- 
 
1. **If you have decided to participate in this, do so with utmost sincerity for full ~1.5-2 hours. I will make the exercise available for later if you wish to try later.**
2. **Don’t disturb others during the exercise by shouting or loudly discussing.** 😊
