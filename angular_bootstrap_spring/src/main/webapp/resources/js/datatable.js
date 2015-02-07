jQuery.fn.dataTableExt.oApi.fnPagingInfo = function(oSettings) {
	return {
		"iStart" : oSettings._iDisplayStart,
		"iEnd" : oSettings.fnDisplayEnd(),
		"iLength" : oSettings._iDisplayLength,
		"iTotal" : oSettings.fnRecordsTotal(),
		"iFilteredTotal" : oSettings.fnRecordsDisplay(),
		"iPage" : oSettings._iDisplayLength === -1 ? 0 : Math
				.ceil(oSettings._iDisplayStart / oSettings._iDisplayLength),
		"iTotalPages" : oSettings._iDisplayLength === -1 ? 0 : Math
				.ceil(oSettings.fnRecordsDisplay() / oSettings._iDisplayLength)
	};
};

var oTable;
$(document).ready(function() {
	$("#table tbody tr").css('cursor', 'pointer');

	oTable = $("#example").DataTable({
		"bProcessing" : true,
		"bServerSide" : true,
		"sort" : "position",
		// bStateSave variable you can use to save state on client cookies: set
		// value "true"
		"bStateSave" : false,
		// Default: Page display length
		"iDisplayLength" : 10,

		"iDisplayStart" : 0,

		"sAjaxSource" : "springPaginationDataTables",
		"aoColumns" : [ {
			"mData" : "noteTitle"
		}, {
			"mData" : "category"
		}, {
			"mData" : "author"
		}, {
			"mData" : "createDate"
		}, {
			"mData" : "rating"
		}, ]
	});

	$('#table tbody').on('click', 'tr', function() {
		var data = oTable.row(this).data();
		document.location.href = "note/" + data.code;
	});
});