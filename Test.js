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

});