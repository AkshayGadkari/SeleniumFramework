#Feature: Home Page buttons functionality (Pause, Resume, Stop)
#
##  Home Page buttons functionality (Stop)
#
#  Scenario: App stop working
#    When : User Opens app "Wakoopa App"
#    And : User clicks on "Stop" button on Home Page
#    Then : App is not active
#
#  Scenario: Open Chrome App
#    When : User Opens app "Chrome App"
#    And :  User Visits "https://www.theguardian.com/"
#    And :  User Visits "https://www.youtube.com/"
#
#    #  Home Page buttons functionality (Pause, Resume)
#
#  Scenario: Open main app
#    When : User Opens app "Wakoopa App"
#    And : User clicks on "Start" button on Home Page
#    Then : App Home Page is Displayed "true"
#    When : User clicks on "Pause" button on Home Page
#    Then : Pause timer is displayed on Home Page
#
#  Scenario: Open other app
#    When : User Opens app {string}
#    Then : User clicks on {string} button in the app
#
#  Scenario: Open main app
#    When : User Opens app "Wakoopa App"
#    And : User clicks on "Resume" button on Home Page
#    Then : App Home Page is Displayed "true"
#    When : Click on Force Sync
#    And : Verify Toast message
#    And : Stop Mobile Driver session
#    And : Wait for "2" minutes
#
#    #  Data validation when app is not active or in pause mode
#
#  Scenario: Kibana data validation when app is not active
#    Given : KIBANA portal is Open
#    And : Select time as "Last 30 minutes"
#    When :User Search for "https://www.theguardian.com/" in KIBANA
#    Then : URL "theguardian.com" is NOT found on Page
#    When :User Search for "www.theguardian.com" in KIBANA
#    Then : URL "www.theguardian.com" is NOT found on Page
#    When :User Search for {string} in KIBANA
#    Then : Check if Value {string} is found on Page
#    And : Quit the Browser
#
#
#
#
#
#
#
#
#
#
#
#
#
#
