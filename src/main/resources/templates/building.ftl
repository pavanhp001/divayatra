<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Building </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="bctrl.successMessage">{{bctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="bctrl.errorMessage">{{bctrl.errorMessage}}</div>
	            <form ng-submit="bctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="bctrl.building.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Building Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="bctrl.building.building_name" id="building_name" class="form-control input-sm" placeholder="Building Name" required />
	                        </div>
	                    </div>
	                </div>
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="near_temple">Near Temple</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="bctrl.building.near_temple" id="near_temple" class="form-control input-sm" placeholder="Near Temple" required />
	                        </div>
	                    </div>
	                </div>
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="destence_from_temple">Distance_from_temple</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="bctrl.building.destence_from_temple" id="destence_from_temple" class="form-control input-sm" placeholder="km" required/>
	                        </div>
	                    </div>
	                </div>
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-1 control-lable" for="addr_no">House No</label>
	                        <div class="col-md-3">
	                            <input type="text" ng-model="bctrl.building.addr_no" id="addr_no" class=" form-control input-sm" placeholder="House No" required/>
	                        </div>
							
							<label class="col-md-1 control-lable" for="addr_city">City</label>
	                        <div class="col-md-3">
	                            <input type="text" ng-model="bctrl.building.addr_city" id="addr_city" class="form-control input-sm" placeholder="City" required/>
	                        </div>
							
							<label class="col-md-1 control-lable" for="addr_dist">Dist</label>
	                        <div class="col-md-3">
	                            <input type="text" ng-model="bctrl.building.addr_dist" id="addr_dist" class="form-control input-sm" placeholder="Dist" required/>
	                        </div>
							
							<label class="col-md-1 control-lable" for="addr_state">State</label>
	                        <div class="col-md-3">
	                            <input type="text" ng-model="bctrl.building.addr_state" id="addr_state" class="form-control input-sm" placeholder="State" required/>
	                        </div>
							
							<label class="col-md-1 control-lable" for="addr_country">Country</label>
	                        <div class="col-md-3">
	                            <input type="text" ng-model="bctrl.building.addr_country" id="addr_country" class="form-control input-sm" placeholder="Country" required/>
	                        </div>
	                    </div>
	                </div>
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="parking_lot">Parking Lot</label>
	                        <div class="col-md-7">
	                            <label>
									<input type="radio" ng-model="bctrl.building.parking_lot" name = "parkingLot" ng-value="Y" class="input-sm">
									Yes
								  </label>
								  <label>
									<input type="radio" ng-model="bctrl.building.parking_lot" name = "parkingLot" ng-value="N" class="input-sm">
									No
								  </label>
	                        </div>
	                    </div>
	                </div>
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="building_img_path">Upload Image</label>
	                        <div class="col-md-7">
								<input type="file" ng-file-select="onFileSelect($files)" ng-model="bctrl.building.building_img_path"  id="building_img_path" class="form-control input-sm" placeholder="Upload Image"/>
	                        </div>
	                    </div>
	                </div>
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="comment">Comment</label>
	                        <div class="col-md-7">
	                            <textarea  type="text" ng-model="bctrl.building.comment" id="comment" class="form-control input-sm" placeholder="Comment" required/></textarea>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!bctrl.building.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="bctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default" ng-if="bctrl.isNotEmpty(bctrl.getCreatedBuilding())">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead"> Created Hotel Details </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>BUILDING_NAME</th>
		                <th>NEAR_TEMPLE</th>
		                <th>DESTENCE_FROM_TEMPLE</th>
						<th>ADDRESS</th>
						<th>PARKING_LOT</th>
						<th>IMAGE</th>
						<th>COMMENT</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr>
		                <td>{{bctrl.building.id}}</td>
		                <td>{{bctrl.building.building_name}}</td>
		                <td>{{bctrl.building.near_temple}}</td>
		                <td>{{bctrl.building.destence_from_temple}}</td>
		                <td>{{bctrl.building.addr_no}}</td>
						<td>{{bctrl.building.parking_lot}}</td>
						<td>{{bctrl.building.building_img_path}}</td>
						<td>{{bctrl.building.comment}}</td>
		                <td><button type="button" ng-click="bctrl.editBuilding(bctrl.building.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="bctrl.removeBuilding(bctrl.building.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
				<a ui-sref="room" class="btn btn-success">Add Rooms</a>
			</div>
		</div>
    </div>
</div>