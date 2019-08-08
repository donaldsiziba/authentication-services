Authentication Services API for Password Compliance

Meta:
@tags component:Password Compliance

Narrative:
As a business owner
I want staff members to use secure passwords when they register
So that I can avoid hackers compromising staff accounts

Scenario: Validate a given password against a set of Compliance Rules
Given the following password <password>
When the password is validated against a defined rule set
Then the result should be <valid>
And the following message should be returned to the user <messages>

Examples:
| password         | valid | messages                                              |
| userp@ssw0rd     | false | Password should have at least one uppercase character |
| USERP@SSW0RD     | fasle | Password should have at least one lowercase character |
| UserP@ssword     | false | Password should have at least one digit |
| UserPassw0rd     | fasle | Password should have at least one special character |
| UserP@sw0rd      | false | Password should be at least 12 characters long |
| UserP@ssw0rD     | true  | |
| userpasword      | fasle | Password should have at least one uppercase character, Password should have at least one digit, Password should have at least one special character, Password should be at least 12 characters long |
| User   P@ss w0rd | false | Password should not have any whitespaces |