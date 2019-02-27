//
//  TaskManagerSample.swift
//  TDDUnitTestsSample
//
//  Created by Mayur Kamthe on 26/02/19.
//  Copyright © 2019 Mayur Kamthe. All rights reserved.
//

import Foundation


class TaskManager: NSObject {
    
    var taskIdList = [Int]()
    
    func addTask(_ testString: String) -> Bool {
        guard !testString.isEmpty else {
            return false
        }
        return true
    }
    
    func createTaskId() {
        taskIdList.removeAll()
        let taskId = Int.random(in: 900 ..< 1000)
        guard taskId != 0 else {
            taskIdList.append(-1)
            return
        }
        taskIdList.append(taskId)
    }
    
    func getTaskID (_ taskId: Int) -> Int {
        guard !taskIdList.isEmpty else {
            return 0
        }
        if let indexOfTask = taskIdList.index(of: taskId) {
            return taskIdList[indexOfTask]
        }
        return 0
    }
    
    func deleteTask(_ taskId: Int) -> Bool{
        guard !taskIdList.isEmpty  else {
            return false
        }
        if let index = taskIdList.index(of: taskId) {
            taskIdList.remove(at: index)
            return true
        }
        return false
    }
}
