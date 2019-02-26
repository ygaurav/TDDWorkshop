
import { TaskManager} from '../TaskManager'
import { expect } from 'chai';
import 'mocha';

describe('Hello function', () => {

  it('check for task create' , () => {
    var taskManager =  new TaskManager() ;
    expect(taskManager.AddTask(null)).to.equal(false);
    
  });

});
