Feature: TV Product Search Journey by Amazon Hamburger Menu


  @DesktopBrowserStart @DesktopBrowserEnd
  @FullRegression
  Scenario: User Visit Amazon website and Check for About this item section for 2nd Highest price Samsung TV
    Given : Amazon is Open
    And : User Clicks on hamburger menu
    And : Scrolls to "shop by department" Section
    And : Clicks on "TV, Appliances, Electronics" link
    And : Clicks on "Televisions" sub link
    And : Scrolls to "Brands" area
#    Currently Brands area shows 7 items only , Sometimes Samsung may not be visible in those 7 items.
    And : Checks "Samsung" check box
#    And : Checks "MI" check box
    And : Selects "Price: High to Low" from Sort by dropdown
    And : Clicks on the second highest price item
    When : Switch to Another Window
    Then : Checks if About this item section is present
    And : wait for "1" min


#  @DesktopBrowser @DesktopBrowserEnd
#  @FullRegression
#  Scenario: Another



