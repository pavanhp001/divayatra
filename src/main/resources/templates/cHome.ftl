<form ng-submit="custCtrl.submit()" name="custForm" class="form-horizontal">
  <div class="row">
    <div class="col-md-2" style="background-color:lavender;">
    <span> Select city</span>
       <select class="col-md-9" placeholder="Select Room Type" ng-model="custCtrl.search.city" ng-options="x for x in custCtrl.cities">
      	 </select>
    </div>
    <div class="col-md-2" style="background-color:lavender;">
		<span> Arrive date</span>
        <input type='date' value="" ng-model="custCtrl.search.arrive_Date">
    </div>
    <div class="col-md-2" style="background-color:lavender;">
    	<span> Dispatch date</span>
        <input type='date' value="" ng-model="custCtrl.search.dispatch_Date">
    </div>
    <div class="col-md-2" style="background-color:lavender;">
      <div class="form-group" ng-class="{ 'has-error' : custForm.trandate.$error }">
        <input type="date" name="trandate" class="form-control" required min="{{custCtrl.max}}" ng-model="custCtrl.search.trandate">
        <p ng-if="custForm.trandate.$touched && custForm.trandate.$error.required" class="help-block">Transaction is required</p>
        <p ng-if="custForm.trandate.$error.date" class="help-block">Transaction should be a valid date</p>
        <p ng-if="custForm.trandate.$error.min" class="help-block">Transaction can't be in past</p>
      </div>
      </div>
    
    <div class="col-md-2" style="background-color:lavender;">
        <input type="submit"  value="Search Hotels" class="btn btn-primary btn-sm" >
    </div>
  </div>
</form>
