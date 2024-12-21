@import gg.jte.Content

@param Content content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My JTE Application</title>
<!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/2.1.8/css/dataTables.dataTables.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
    <script src="https://cdn.datatables.net/plug-ins/2.1.8/sorting/datetime-moment.js"></script>
-->
    <script src="/js/jquery-3.7.1.js"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/dataTables.dataTables.css" rel="stylesheet">
    <script src="/js/bootstrap.bundle.min.js"></script>
    <script src="/js/datatables.min.js"></script>
    <script src="/js/moment.min.js"></script>
    <script src="/js/datetime-moment.js"></script>
    <!--
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/dataTables.dataTables.css" rel="stylesheet">
    <script src="/js/jquery-3.7.1.js"></script>
    <script src="/jsfnappdata/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/datetime-moment.js"></script>
-->
    <!--  Add JSPDF -->
</head>
<body>

@template.layout.header()

<div class="d-flex">
    @template.layout.sidebar()

    <main class="flex-grow-1 p-4">
        ${content}
    </main>
</div>

@template.layout.footer()
    <script type="text/javascript">
    let obj = {sClass: 'example'};
    $(document).ready(function() {
    //    $.fn.dataTable.moment( 'DD-MM-YYYY' );
    //    $.fn.dataTable.moment( 'dddd, MMMM Do, YYYY' );

        new DataTable('#example', {
            ajax: '/objects_ddmmyyyy.txt',
            columns: [
                { data: 'name' },
                { data: 'position' },
                { data: 'office' },
                { data: 'extn' },
                { data: 'start_date' },
                { data: 'salary' }
            ]
        });

/*

        // Initialize DataTable
        $("#example").DataTable({
            columns: [
                { title: "ID" },
                { title: "Name" },
                { title: "Position" },
                { title: "Salary" },
                { title: "Start Date" },
                { title: "Office" },
                { title: "Extn" }
            ]
        });

        // AJAX call to fetch the JSON data
        $.ajax({
            url: "/objects_ddmmyyyy.txt",
            dataType: "text", // Specify that we expect text
            success: function(result) {
                const obj11 = JSON.parse(result);
                console.log(obj11.data);

                $.each(obj11.data, function(i, val) {
                    // Add each employee's data as a new row in the DataTable

                    $("#example").DataTable().row.add([
                        val.id,
                        val.name,
                        val.position,
                        val.salary,
                        val.start_date,
                        val.office,
                        val.extn
                    ]).draw();

                    var obj12 = [
                        val.id,
                        val.name,
                        val.position,
                        val.salary,
                        val.start_date,
                        val.office,
                        val.extn
                    ];
                    $("#example").dataTable().fnAddData(obj12);
                });
            },
            error: function(xhr, status, error) {
                console.error("Error fetching data:", status, error);
            }
        });
       */
    } );
    </script>
</body>
</html>