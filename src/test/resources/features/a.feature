Feature: Product Search Journey via Amazon Hamburger Menu


  @DesktopBrowserStart @DesktopBrowserEnd
  @FullRegression
  Scenario: To Visit Amazon website
    Given : Amazon is Open
    And : User Clicks on hamburger menu
    And : Scrolls to "shop by department" Section
    And : Clicks on "TV, Appliances, Electronics" link
    And : Clicks on "Televisions" sub link
    And : Scrolls to "Brands" area
    And : Checks "Samsung" check box
    And : Selects "Price: High to Low" from Sort by dropdown
    And : wait for "1" min


#  @DesktopBrowser @DesktopBrowserEnd
#  @FullRegression
#  Scenario: Another



