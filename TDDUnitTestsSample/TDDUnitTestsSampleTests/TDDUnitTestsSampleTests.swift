//
//  TDDUnitTestsSampleTests.swift
//  TDDUnitTestsSampleTests
//
//  Created by Mayur Kamthe on 26/02/19.
//  Copyright © 2019 Mayur Kamthe. All rights reserved.
//

import XCTest
@testable import TDDUnitTestsSample

class TDDUnitTestsSampleTests: XCTestCase {

    var taskManagerObj: TaskManager!
    
    override func setUp() {
         taskManagerObj = TaskManager()
    }
    
    override func tearDown() {
        taskManagerObj = nil
    }

    func testCheckEmptyString() {
        XCTAssert(taskManagerObj.addTask(""))
    }
    
    func testRandomNoCreation() {
        taskManagerObj.createTaskId()
        XCTAssertNil(taskManagerObj.getTaskID(999), "Task id is not empty")
    }
    
    func testDeleteTask() {
        XCTAssertTrue(taskManagerObj.deleteTask(999))
    }

}
