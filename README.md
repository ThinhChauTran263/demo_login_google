# Demo OAuth2 Login với Google

Demo đăng nhập bằng tài khoản Google sử dụng Spring Boot 3 và Spring Security 6.

## Yêu cầu

- Java 21
- Maven 3.6+

## Cấu trúc project

```
src/main/java/poly/edu/demo_autho2_gg_fb/
├── DemoAuthO2GgFbApplication.java    # Main class
├── config/
│   └── SecurityConfig.java           # Cấu hình Spring Security
└── controller/
    └── HomeController.java           # Xử lý request

src/main/resources/
├── application.yml                   # Cấu hình chung
├── application-local.yml             # Credentials (tự tạo, không push git)
├── static/css/style.css              # CSS
└── templates/
    ├── index.html                    # Trang đăng nhập
    └── user.html                     # Trang thông tin user
```

## Hướng dẫn chạy

### Bước 1: Tạo Google OAuth2 Credentials

1. Vào [Google Cloud Console](https://console.cloud.google.com/)
2. Tạo project mới hoặc chọn project có sẵn
3. Vào **APIs & Services** → **Credentials**
4. Click **Create Credentials** → **OAuth 2.0 Client ID**
5. Chọn Application type: **Web application**
6. Thêm **Authorized redirect URIs**:
   ```
   http://localhost:8080/login/oauth2/code/google
   ```
7. Copy **Client ID** và **Client Secret**

### Bước 2: Cấu hình credentials

Tạo file `src/main/resources/application-local.yml`:

```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: YOUR_CLIENT_ID
            client-secret: YOUR_CLIENT_SECRET
```

### Bước 3: Chạy ứng dụng

```bash
mvn spring-boot:run
```

### Bước 4: Truy cập

Mở trình duyệt: http://localhost:8080

## Luồng hoạt động

```
1. User truy cập "/" → Hiển thị trang đăng nhập
2. Click "Đăng nhập với Google" → Chuyển đến Google
3. User đăng nhập Google → Google callback về app
4. App nhận thông tin user → Chuyển đến "/user"
5. Hiển thị tên, email, ảnh đại diện
6. Click "Đăng xuất" → Quay về trang chủ
```

## Tech Stack

- Spring Boot 3.4.1
- Spring Security 6 (OAuth2 Client)
- Thymeleaf
- Java 21
- Maven
