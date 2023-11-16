import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainSwiftUIControllerKt.MainSwiftUIController(
            text: sumArray([7, 5, 9])
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
    func sumArray(_ array: [Int]) -> String {
        var result = 0
        for value in array {
            result += value
        }
        
        return "The sum is: \(result)"
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



