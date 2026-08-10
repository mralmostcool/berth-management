import type { Metadata } from "next";
import "./globals.css";

export const metadata: Metadata = {
  title: "Berth Management System",
  description: "Berth Management System Console",
};

export default function RootLayout({ children }: LayoutProps<"/">) {
  return (
    <html lang="en">
      <body>
        {children}
      </body>
    </html>
  );
}
