# BookingAutomationTask
This task implemented using
Selenium webdriver
Data Driven Framework
Maven to manage dependencies
TestNG as testing framework
Page Object Model design pattern
Apache-POI to handle excel 

Utilities summary
ElementActions class:
Include wrappers to handle element actions with help of waiting conditions

ConfigReader:
contain method to Read configuration property file that contains configuration such as browser used, wait time, url and file paths

ExcelReader:
contain method to read Excel file has test data

BookingCalender:
Has two methods one to set check in date to be current date and the other one to set check out date to be after month

SwitchToNewWindow:
Has method to handle switching to new opened windows

