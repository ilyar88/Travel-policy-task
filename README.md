# Automation task for Harel

## About

Check travel policy website.

## Test case description

1. Open the Travel Policy URL in the Chrome browser
2. Click the “First-time purchase” button
3. Select a continent, for example: Canada
4. Click “Continue to select travel dates” button
5. Using the date picker:
<br/>• Select a departure date 7 days from today
<br/>• Select a return date 30 days after the departure date
6. Verify that the total number of travel days is displayed correctly
7. Click “Continue to passenger details” button
8. Verify that the Passenger Details page opens successfully

---

## Run the test case as described

Run git clone in the terminal:
   ```bash
   git clone https://github.com/ilyar88/Travel-policy-task.git
   ```

Run mvn test in the terminal:
   ```bash
   mvn clean test
   ```