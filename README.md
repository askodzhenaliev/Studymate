# Studymate
Team Rules & Expectations

Just a few things so we can stay organized and keep the project clean:

1️⃣ Everyone works in their own branch
Please don’t push directly to main/production.
Create your branch like this:
yourname/feature-name
Example: asylbek/login-tests

2️⃣ Stick to the POM structure
Each page should have its own class, and tests should be in the test package.
Try not to mix multiple pages or responsibilities in one file.

3️⃣ No hardcoded waits
Use proper explicit waits or the utilities from the framework.
Thread.sleep() should be avoided.

4️⃣ Use clear, meaningful names
Methods, variables, locators, test classes — everything should make sense when we read it later.

5️⃣ Make sure your tests have assertions
Don’t just click through the flow. Every test should validate something.

6️⃣ Commit and push regularly
Small, frequent updates help avoid big merge conflicts.
Also, pull from main often so your branch stays updated.

7️⃣ Before opening a pull request
Check that your code compiles and your test runs without failures.
If something is broken, fix it first.
