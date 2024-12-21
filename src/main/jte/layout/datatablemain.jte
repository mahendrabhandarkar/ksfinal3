@import gg.jte.Content

@param Content content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My JTE Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My JTE Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/2.1.8/css/dataTables.dataTables.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
    <script src="https://cdn.datatables.net/plug-ins/2.1.8/sorting/datetime-moment.js"></script>
    <script src="/webjars/lodash/4.17.21/lodash.min.js"></script>
    <!--  Add JSPDF META-INF/resources/webjars/lodash/4.17.21/lodash.min.js -->
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
    $(document).ready(function() {
        $("#example thead tr").clone(true).addClass('filters').appendTo("#example thead");
        $('#example').DataTable({
                initComplete: function() {
                    /*
                    // Code for adding search filter on above every column heading
                    this.api().columns().every(function() {
                    let column = this;
                    let title = column.header().textContent;

                    // Create input element
                    let input = document.createElement('input');
                    input.placeholder = title;
                    column.header().append(input);

                    // Event listener for user input
                    input.addEventListener('keyup', () => {
                        if(column.search() !== this.value) {
                            column.search(input.value).draw();
                        }
                    });
                });

                var r = $("#example thead tr")
                .clone(true)
                .addClass('filters')
                .appendTo("#example thead");
                */
            var api = this.api();

            // For each column
            api
            .columns()
            .eq(0)
            .each(function (colIdx) {
                // Set the header cell to contain the input element
                var cell = $('.filters th').eq(
                    $(api.column(colIdx).header()).index()
                );
                var title = $(cell).text();

                if(colIdx != 6 && colIdx != 7){
                    $(cell).html('<input type="text" class="dt-input" placeholder="' + title + '" />');
                }else{
                    $(cell).html('');
                }

                // On every keypress in this input
                $(
                    'input',
                    $('.filters th').eq($(api.column(colIdx).header()).index())
                )
                .on('keyup change', function (e) {
                    api
                    .column(colIdx)
                    .search(
                        this.value
                    )
                    .draw();
                });
            });

            },
            orderCellsTop: true,
            fixedHeader: true,
            ordering: true,
            processing: true,
            searching: true,
            serverSide: true,
            responsive: true,
            ajax: {
                url: '/api/listc', // Ensure this URL is correct
                type: 'POST',
/*                contentType: 'application/json',
*/                data: function(d) {
                    console.log(d); // Log DataTables parameters for debugging
                    return d; // Send DataTables parameters as JSON
                },
/*                dataSrc: function(json) {
                    let json1 = JSON.stringify(json);
                    console.log(json.data);
                    return json1.data; // Assuming your response has a 'data' field for items
                },
*/                error: function(jqXHR, textStatus, errorThrown) {
                    console.error('AJAX error:', textStatus, errorThrown);
                }
            },
            columns: [
                { data: 'name' },
                { data: 'iso' },
                { data: 'sortname' },
                { data: 'iso3' },
                { data: 'numcode' },
                { data: 'phonecode' }
            ],
            columnDefs: [{
                target:0,
                render: function(data, type, row) {
                    // console.log(data);
                    if(type==='sort' || type==='type') {
                        // Here we can put logic to date filter
                        return data;
                    }
                    return data;
                }
            }],
            order: [[0, 'asc']], // Default ordering by the first column (name)
            pagingType: 'full_numbers', // Pagination Type,
            lengthMenu: [[10, 25, 50, -1], [10, 25, 50, 'All']],
            language: {
                emptyTable: '<span>No data available mahi</span>',
                paginate: {
                    next: 'Next',
                    previous: 'Previous'
                }
            }
        });
    });
    </script>
</body>
</html>