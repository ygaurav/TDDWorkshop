//
//  TaskManagerSample.swift
//  TDDUnitTestsSample
//
//  Created by Mayur Kamthe on 26/02/19.
//  Copyright © 2019 Mayur Kamthe. All rights reserved.
//

import Foundation


class TaskManager: NSObject {
    
    var taskIdList = [Task]()
    
    func addTask(_ testString: String) -> Bool {
        guard !testString.isEmpty else {
            return false
        }
        return true
    }
    
    func createTaskId(_ description: String, deadline: String) {
        taskIdList.removeAll()
        
        let taskObj = Task()
        taskObj.id = randomString(length: 10)
        taskObj.description = description
        taskObj.deadline = deadline
        
        guard !taskObj.id.isEmpty else {
            let taskEmpty = Task()
            taskEmpty.id = "-1"
            taskIdList.append(taskEmpty)
            return
        }
        taskIdList.append(taskObj)
    }
    
    func randomString(length: Int) -> String {
        let letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return String((0...length-1).map{ _ in letters.randomElement()! })
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

class  Task {
    var id = ""
    var description = ""
    var deadline = ""
}
