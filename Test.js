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

    it('It should return Task ID on Success', function() {
        var task = new Task();
        task.fnSaveTaskID('a');
    });

    it('It should return Task Based on Task ID', function() {
        var task = new Task();
        //task.fnReturnTask(8);
    });

    it('It should return Nummber of Tasks', function() {
        var task = new Task();
        task.fnReturnCountValue;
    })
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
            var sTaskString = [];
            sTaskString = iTaskID.split(' ');
            for (var i = 0; i < sTaskString.length; i++) {
                if (sTaskString[i].includes('@')) {
                    var pattern = /^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
                    var sdateValue = sTaskString[i].split('@')[1]
                    if (pattern.test(sdateValue)) {
                        aTaskID.push(iTaskID);
                        iTaskValue = iTaskValue + 1
                        return iTaskValue;
                    } else {
                        return -1
                    }
                } else {
                    return -1
                }
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
    console.log(task.fnSaveTaskID('going on @28/02/1967'));
    console.log(task.fnSaveTaskID('b'));
    console.log(task.fnSaveTaskID('c'));
    task.fnDeleteTask(2);
    console.log(aTaskID);
    console.log(task.fnReturnCountValue())
});