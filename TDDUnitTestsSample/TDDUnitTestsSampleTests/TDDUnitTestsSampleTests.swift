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
    
    func testRandomNoCreation() {
        taskManagerObj.createTaskId()
        XCTAssertTrue(!taskManagerObj.taskIdList.isEmpty, "Task id is empty")
    }
    
    func testFetchTaskId() {
        XCTAssertNil(taskManagerObj.getTaskID(999), "TaskId not present in the list")
    }
    
    func testDeleteTask() {
        XCTAssertTrue(taskManagerObj.deleteTask(999), "TaskId not present in the list")
    }

}
