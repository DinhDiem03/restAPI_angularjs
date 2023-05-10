let app = angular.module("myApp", []);
app.controller("myController", function ($scope, $http) {
  $scope.lists = [];

  $scope.viTri = -1;
  $scope.request = {
    tenSp: "",
    mau: "",
    soLuong: 0,
    giaNhap: 0,
    giaBan: 0,
    moTa: "",
    idSubLoaiSp: 0,
    idTrangThai: 0,
    idHang: 0,
  };

  let url = "http://localhost:8080/san-pham";
  let api = url + "/hien-thi";

  hienThi();
  function hienThi() {
    $http.get(api).then(function (response) {
      $scope.lists = response.data;
      console.log(response.data);

      $(document).ready(function () {
        dTable = $("#myTable");
        dTable.DataTable();
      });
      
    }),
      function (errors) {
        console.log(errors);
      };
  }

  //
  //detail
  $scope.getOne = function (event, id, index) {
    event.preventDefault();

    $http.get(api + "/" + id).then(function (response) {
      let sv = $scope.list;
      sv = response.data;
      $scope.request.tenSp = sv.tenSp;
      $scope.request.mau = sv.mau;
      $scope.request.soLuong = sv.soLuong;
      $scope.request.giaNhap = sv.giaNhap;
      $scope.request.giaBan = sv.giaBan;
      $scope.request.moTa = sv.moTa;

      for (var i = 0; i < $scope.listHangSp.length; i++) {
        if ($scope.listHangSp[i].sanPham.id === sv.id) {
          console.log($scope.listHangSp[i].sanPham.id);
          $scope.request.idHang = $scope.listHangSp[i].hang.id;
        }
      }

      $scope.request.idSubLoaiSp = sv.subLoaiSanPham.id;
      $scope.request.idTrangThai = sv.trangThai.id;
      $scope.viTri = index;
    });
  };
  //xóa
  $scope.delete = function (event, id) {
    event.preventDefault();
    let api = url + "/delete/" + id;
    $http.delete(api).then(function () {
      hienThi();
      alert("Xóa thành công");
    }),
      function (errors) {
        console.log(errors);
      };
  };
  // update
  $scope.updateSanPham = function () {
    if ($scope.viTri === -1) {
      alert("Vui long chon dong muon update");
    } else if ($scope.request.idSubLoaiSp === 0) {
      alert("Vui long chon id sub hop le");
    } else if ($scope.request.idTrangThai === 0) {
      alert("Vui long chon id trang thai hop le");
    } else if ($scope.request.idHang === 0) {
      alert("Vui long chon id hang hop le");
    } else {
      let sv = $scope.lists[$scope.viTri];

      console.log($scope.lists[1].id);
      let api = url + "/update/" + sv.id;
      $http.put(api, JSON.stringify($scope.request)).then(function () {
        alert("Update Sinh Vien thanh cong");
        hienThi();
      }),
        function (errors) {
          console.log(errors);
        };
    }
  };

  // add
  $scope.addSanPham = function () {
    console.log($scope.request.idSubLoaiSp);
    if ($scope.request.idSubLoaiSp === 0) {
      alert("Vui long chon id sub hop le");
    } else if ($scope.request.idTrangThai === 0) {
      alert("Vui long chon id trang thai hop le");
    } else if ($scope.request.idHang === 0) {
      alert("Vui long chon id hang hop le");
    } else {
      let api = url + "/add";
      $http.post(api, JSON.stringify($scope.request)).then(function () {
        alert("Add san pham thanh cong");
        hienThi();
      }),
        function (errors) {
          console.log(errors);
        };
    }
  };
  $scope.listTrangThai = [];
  let urlTT = "http://localhost:8080/trang-thai";
  let apiTT = urlTT + "/hien-thi";
  hienThiTT();
  function hienThiTT() {
    $http.get(apiTT).then(function (response) {
      $scope.listTrangThai = response.data;
    }),
      function (errors) {
        console.log(errors);
      };
  }

  $scope.listSubLoai = [];
  let urlSub = "http://localhost:8080/sub-loai";
  let apiSub = urlSub + "/hien-thi";
  hienThiSubLoai();
  function hienThiSubLoai() {
    $http.get(apiSub).then(function (response) {
      $scope.listSubLoai = response.data;
    }),
      function (errors) {
        console.log(errors);
      };
  }
  $scope.listHang = [];

  let urlhang = "http://localhost:8080/hang";
  let apihang = urlhang + "/hien-thi";
  hienThiHang();
  function hienThiHang() {
    $http.get(apihang).then(function (response) {
      $scope.listHang = response.data;
    }),
      function (errors) {
        console.log(errors);
      };
  }

  $scope.listHangSp = [];

  let urlhangsp = "http://localhost:8080/hangsp";
  let apihangsp = urlhangsp + "/hien-thi";
  hienThiHangSp();
  function hienThiHangSp() {
    $http.get(apihangsp).then(function (response) {
      $scope.listHangSp = response.data;
    }),
      function (errors) {
        console.log(errors);
      };
  }
});
