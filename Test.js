var assert = require('assert');


describe('TDD', function() {

    it('It should return false', function() {
        var taskManager = new TaskManager('');
        taskManager.AddTask
    });

    //true test case
    it('It should return true', function() {
        var taskManager = new TaskManager('Test');
        taskManager.AddTask
    });


    class TaskManager {
        constructor(sName = '') {
            this.sName = sName;
        }

        AddTask(sName) {
            return sName ? 0 : 1;
        }
    }

    var aTaskID = [];
    var iTaskValue = 0;
    class Task {
        constructor(TaskID) {
            this.TaskID = TaskID;
        }
        fnSaveTaskID(iTaskID) {
            aTaskID.push(iTaskID)
            if (aTaskID.includes(iTaskID)) {
                iTaskValue = iTaskValue + 1
                return iTaskValue;
            } else {
                return -1
            }

        }

        fnReturnTask(iTId) {
            return aTaskID[iTId - 1]
        }

        fnReturnCountValue() {
            return aTaskID.length
        }

        fnDeleteTask(iTaskDelete) {
            aTaskID.splice((iTaskDelete - 1), 1);

        }

    }

    var task = new Task();
    // var task = new Task('test');
    // var task = new Task('test');
    console.log(task.fnSaveTaskID('a'));
    console.log(task.fnSaveTaskID('b'));
    console.log(task.fnSaveTaskID('c'));
    task.fnDeleteTask(2);
    console.log(aTaskID);
    console.log(task.fnReturnCountValue())
});