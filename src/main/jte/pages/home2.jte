@param String username

@template.layout.datatablemain(content = @`
<div class="bg-white shadow rounded p-4">
    <h1>Welcome, ${username}!</h1>
    <p>This is your dashboard.</p>
    <table id="example" class="display datatable" style="width:100%">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>ISO</th>
                    <th>Sortname</th>
                    <th>ISO3</th>
                    <th>Num code</th>
                    <th>Phone code</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th>Name</th>
                    <th>ISO</th>
                    <th>Sortname</th>
                    <th>ISO3</th>
                    <th>Num code</th>
                    <th>Phone code</th>
                </tr>
            </tfoot>
        </table>
</div>
`)