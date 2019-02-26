//
//  TaskManagerSample.swift
//  TDDUnitTestsSample
//
//  Created by Mayur Kamthe on 26/02/19.
//  Copyright © 2019 Mayur Kamthe. All rights reserved.
//

import Foundation


class TaskManager: NSObject {
    
    func addTask(_ testString: String) -> Bool {
        guard !testString.isEmpty else {
            return false
        }
        return true
    }
}
