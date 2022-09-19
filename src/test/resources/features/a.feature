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
    And : Click on the second highest priced item
    And : wait for "1" min

#  //span[@class='a-price-whole']
#  //span[normalize-space()='12,49,990']
#  //h1[normalize-space()='About this item']

#  @DesktopBrowser @DesktopBrowserEnd
#  @FullRegression
#  Scenario: Another



