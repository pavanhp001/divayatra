<p> hotel Data </p>
<div class="generic-container">
    <div class="panel panel-default" ng-if="CHctrl.isNotEmpty(CHctrl.getCreatedBuilding())">
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