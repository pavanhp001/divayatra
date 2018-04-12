<div class="generic-container">
	<div class="panel panel-default" ng-if="rctrl.isNotEmpty(rctrl.getCreatedBuilding())">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead"> Hotel Details </span></div>
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
		            </tr>
		            </thead>
		            <tbody>
		            <tr>
		                <td>{{rctrl.createdBuildingData.id}}</td>
		                <td>{{rctrl.createdBuildingData.building_name}}</td>
		                <td>{{rctrl.createdBuildingData.near_temple}}</td>
		                <td>{{rctrl.createdBuildingData.destence_from_temple}}</td>
		                <td>{{rctrl.createdBuildingData.addr_no}}</td>
						<td>{{rctrl.createdBuildingData.parking_lot}}</td>
						<td>{{rctrl.createdBuildingData.building_img_path}}</td>
						<td>{{rctrl.createdBuildingData.comment}}</td>
		             </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
    
    <div class="panel panel-default" ng-if="!rctrl.isNotEmpty(rctrl.getCreatedBuilding())">
       <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Create Room Data</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <form ng-submit="rctrl.submit()" name="buildingForm" class="form-horizontal">
	                <input type="hidden" ng-model="rctrl.room.id" />
	                <input type="hidden" ng-model="rctrl.room.building_id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="room_no">Hotel Id</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="rctrl.createdBuildingData.id" id="building_id" class="form-control input-sm" placeholder="Hotel Id" required />
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <button type="button" ng-click="rctrl.getBuildingData(rctrl.createdBuildingData.id)" class="btn btn-warning btn-sm" >Get Building Data</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    


    <div class="panel panel-default" ng-if="rctrl.isNotEmpty(rctrl.getCreatedBuilding())">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Create Room Data</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="rctrl.successMessage">{{rctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="rctrl.errorMessage">{{rctrl.errorMessage}}</div>
	            <form ng-submit="rctrl.submit()" name="roomForm" class="form-horizontal">
	                <input type="hidden" ng-model="rctrl.room.id" />
	                <input type="hidden" ng-model="rctrl.room.building_id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="room_no">Room No</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="rctrl.room.room_no" id="room_no" class="form-control input-sm" placeholder="Room No" required />
	                        </div>
	                    </div>
	                </div>
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="room_no">Room No</label>
	                        <div class="col-md-7">
	                            <select placeholder="Select Room Type" ng-model="rctrl.room.room_type" ng-options="x for x in rctrl.room_types">
								</select>
	                        </div>
	                    </div>
	                </div>
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="priceper_day">Price per day</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="rctrl.room.priceper_day" id="priceper_day" class="form-control input-sm" placeholder="Price per day" required />
	                        </div>
	                    </div>
	                </div>
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="room_img_path">Upload Image</label>
	                        <div class="col-md-7">
								<input type="file" ng-file-select="onFileSelect($files)" ng-model="rctrl.room.room_img_path"  id="room_img_path" class="form-control input-sm" placeholder="Upload Image"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!rctrl.room.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="roomForm.$invalid || roomForm.$pristine">
	                        <button type="button" ng-click="rctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="roomForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="isActive">IsActive</label>
	                        <div class="col-md-7">
	                            <label>
									<input type="radio" ng-model="rctrl.room.isActive" name = "isActive" ng-value="Y" class="input-sm">
									Yes
								  </label>
								  <label>
									<input type="radio" ng-model="rctrl.room.isActive" name = "isActive" ng-value="N" class="input-sm">
									No
								  </label>
	                        </div>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    {{rctrl.rooms[0].id}}
    <div class="panel panel-default" ng-if="rctrl.showRoomDetails">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead"> Created Room Details </span></div>
		    <div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>ROOM TYPE</th>
		                <th>ROOM NO</th>
		                <th>PRICEPER DAY</th>
						<th>IMAGE</th>
						<th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="room in rctrl.getAllRooms()">
		                <td>{{room.id}}</td>
		                <td>{{room.room_type}}</td>
		                <td>{{room.room_no}}</td>
		                <td>{{room.priceper_day}}</td>
		                <td>{{room.room_img_path}}</td>
						<td><button type="button" ng-click="rctrl.editRoom(room.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="rctrl.removeRoom(room.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>