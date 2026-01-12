# Automation task for Harel

### Scope

1. Task objective: 
<br/>• My task was to test the system from the customer’s perspective when purchasing travel insurance abroad
<br/>• To ensure that the travel insurance purchase process works as expected
<br/><br/>
2. Assumptions taken into account:
<br/>• Assuming that the element names and identifiers don't change, there are no delays when clicking on button that required additional checks to ensure that the element is clickable, the URIs is fixed, and the steps in the process can be performed as expected without exception like: NoSuchElement, elementClickIntercepted or WebDriverException
<br/><br/>
3. Limitations and risks:
<br/>• The test was performed on a basic purchase scenario for travel insurance
<br/>• The focus was on UI and E2E testing using Selenium, Java, and TestNG
<br/>• The test was performed assuming that the elements, URI, and business flow are stable
<br/><br/>
4. Additional tests
<br/>• Edge cases such as invalid dates, navigating back, and refreshing page how it will affect the purchasing process?
<br/>• Testing the same testcase in parallel across multiple browsers using Selenium Grid
<br/>• Add an Allure report with screenshots or recordings with Licenser class implementation in case of failure
<br/>• Testing UI with AI using Applitools

### Testcase description

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

### Run the testcase as described

Run git clone in the terminal:
   ```bash
   git clone https://github.com/ilyar88/Travel-policy-task.git
   ```

Run mvn test in the terminal:
   ```bash
   mvn clean test
   ```
   
---  
   
### In conclusion:

I would start with the critical scenarios in the sanity or in the regression testing, such as purchasing insurance abroad, and then move on to less critical scenarios in the priority.